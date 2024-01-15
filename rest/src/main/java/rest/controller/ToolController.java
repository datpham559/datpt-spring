package rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.dto.ToolRequestDTO;
import rest.service.ToolAutomationService;

@RestController
@RequestMapping(value = "/api")
public class ToolController {
    private final ToolAutomationService toolAutomationService;

    public ToolController(ToolAutomationService toolAutomationService) {
        this.toolAutomationService = toolAutomationService;
    }
    @PostMapping(value = "/tool")
    public void toolAutomation(@RequestBody ToolRequestDTO dto){
        toolAutomationService.toolAutomationComment(dto);
        return;
    }
}
