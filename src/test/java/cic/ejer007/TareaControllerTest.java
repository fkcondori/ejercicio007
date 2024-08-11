package cic.ejer007;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TareaController.class)
public class TareaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "USER")
    public void testCompletarTarea_ConRolUsuario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/tareas/1/completar"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testCompletarTarea_ConRolAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/tareas/2/completar"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(roles = "GUEST")
    public void testCompletarTarea_SinRolAdecuado() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/tareas/1/completar"))
               .andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}