package com.plahotin.copsboot.controller.user;

import com.plahotin.copsboot.SpringProfiles;
import com.plahotin.copsboot.model.user.Users;
import com.plahotin.copsboot.security.AuthorizationServerConfiguration;
import com.plahotin.copsboot.security.SecurityConfiguration;
import com.plahotin.copsboot.security.WebSecurityGlobalConfig;
import com.plahotin.copsboot.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.plahotin.copsboot.security.SecurityHelperForMockMvc.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
@ActiveProfiles(SpringProfiles.TEST)
public class UserRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @TestConfiguration
    @Import({AuthorizationServerConfiguration.class, ResourceServerConfiguration.class, WebSecurityGlobalConfig.class})
    static class TestConfig {
        @Bean
        public UserDetailsService userDetailsService() {
            return new StubUserDetailsService();
        }

        @Bean
        public SecurityConfiguration securityConfiguration() {
            return new SecurityConfiguration();
        }
    }

    @Test
    public void givenNotAuthenticated_whenAskingMyDetails_forbidden() throws Exception {
        mvc.perform(get("/api/users/me"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void givenAuthenticatedAsOfficer_whenAskingMyDetails_detailsReturned() throws Exception {
        String accessToken = obtainAccessToken(mvc, Users.OFFICER_EMAIL, Users.OFFICER_PASSWORD);

        when(service.getUser(Users.officer().getId())).thenReturn(Optional.of(Users.officer()));

        mvc.perform(get("/api/users/me")
                .header(HEADER_AUTHORIZATION, bearer(accessToken)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("email").value(Users.OFFICER_EMAIL))
                .andExpect(jsonPath("roles").isArray())
                .andExpect(jsonPath("roles[0]").value("OFFICER"));
    }
}
