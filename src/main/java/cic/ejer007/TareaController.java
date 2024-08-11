package cic.ejer007;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/{id}")
    public Tarea obtenerTarea(@PathVariable Long id) {
        return tareaService.getTarea(id);
    }

    @PostMapping("/{id}/completar")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void completarTarea(@PathVariable Long id) {
        tareaService.marcarTareaComoCompletada(id);
    }
}

