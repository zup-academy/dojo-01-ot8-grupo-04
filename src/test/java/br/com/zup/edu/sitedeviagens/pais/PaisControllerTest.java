package br.com.zup.edu.sitedeviagens.pais;

import br.com.zup.edu.sitedeviagens.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PaisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private void performarRequest(PaisForm paisForm, ResultMatcher matcher) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/paises")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(paisForm))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(matcher);
    }

    @Test
    public void deveRetornarSucessoAoCriarNovoPais() throws Exception {
        PaisForm paisForm = new PaisForm("Brasil");
        performarRequest(paisForm, status().isCreated());
    }
}