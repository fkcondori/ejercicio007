package cic.ejer007;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class TareaService {

    private final Map<Long, Tarea> tareas = new HashMap<>();

    public TareaService() {
        // Inicializamos con algunas tareas de ejemplo
        tareas.put(1L, new Tarea(1L, "Tarea 1"));
        tareas.put(2L, new Tarea(2L, "Tarea 2"));
    }

    public Tarea getTarea(Long id) {
        return tareas.get(id);
    }

    public void marcarTareaComoCompletada(Long id) {
        Tarea tarea = tareas.get(id);
        if (tarea != null) {
            tarea.setCompletada(true);
        }
    }
}

