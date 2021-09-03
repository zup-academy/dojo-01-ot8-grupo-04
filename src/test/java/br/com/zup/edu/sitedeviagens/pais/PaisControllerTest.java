package br.com.zup.edu.sitedeviagens.pais;

import br.com.zup.edu.sitedeviagens.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
        performarRequest(paisForm, status().isOk());
    }
}