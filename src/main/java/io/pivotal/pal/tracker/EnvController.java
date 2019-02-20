package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private final String port;
    private final String memoryLimit;
    private final String instanceIndex;
    private final String instanceAddr;

    public EnvController(
            @Value("${port:None}") String port,
            @Value("${memory.limit:Infinite}") String memoryLimit,
            @Value("${cf.instance.index:Not Set}") String instanceIndex,
            @Value("${cf.instance.addr:Not Set}") String instanceAddr
    ) {

        this.port = port;
        this.memoryLimit = memoryLimit;
        this.instanceIndex = instanceIndex;
        this.instanceAddr = instanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<String, String>();
        env.put("PORT", this.port);
        env.put("MEMORY_LIMIT", this.memoryLimit);
        env.put("CF_INSTANCE_INDEX", this.instanceIndex);
        env.put("CF_INSTANCE_ADDR", this.instanceAddr);

        return env;
    }
}
