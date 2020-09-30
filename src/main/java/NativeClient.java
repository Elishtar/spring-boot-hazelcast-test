import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NativeClient {

    public static void main(String[] args) throws InterruptedException {
        ClientConfig config = new ClientConfig();
        final ClientNetworkConfig networkConfig = config.getNetworkConfig();
        networkConfig.addAddress("http//localhost:8080");
        config.setInstanceName("hazelcast-instance");
        HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(config);
        while (true) {
            TimeUnit.SECONDS.sleep(1);
        }
////        IMap<Long, Employee> map = hazelcastInstanceClient.getMap("my-map");
////        for (Map.Entry<Long, Employee> entry : map.entrySet()) {
////            System.out.println(entry.getKey() +
////                    "   " + entry.getValue().getId() +
////                    "   " + entry.getValue().getName()  +
////                    "   " + entry.getValue().getSex()  +
////                    "   " + entry.getValue().getSize()
////            );
//        final ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig();
//        managementCenterConfig.setUrl("http://localhost:8080/mancenter");


    }
}
