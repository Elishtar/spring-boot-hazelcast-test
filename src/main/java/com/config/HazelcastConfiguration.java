//package com.config;
//
//import com.Employee;
//import com.hazelcast.config.*;
//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;
//import com.hazelcast.jet.Jet;
//import com.hazelcast.jet.JetInstance;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Map;
//
//@Configuration
//public class HazelcastConfiguration {
//    @Bean
//    public Config hazelCastConfig(){
//        Config config = new Config();
//        final NetworkConfig networkConfig = config.getNetworkConfig();
//        networkConfig.setPort(5701).setPortCount(20);
//        networkConfig.setPortAutoIncrement(true);
////        config.getGroupConfig().setName("dev");
////        config.getGroupConfig().setPassword("dev");
////        config.getManagementCenterConfig().setEnabled(true);
//
////        NetworkConfig network = config.getNetworkConfig();
////        network.setPort(5701).setPortCount(20);
////        network.setPortAutoIncrement(true);
////        JoinConfig join = network.getJoin();
////        join.getMulticastConfig().setEnabled(false);
////        join.getTcpIpConfig().setEnabled(true);
////                .addMember("machine1")
////                .addMember("localhost").setEnabled(true);
//
////        config.getManagementCenterConfig().setEnabled(true).setUrl("http://localhost:8080/mancenter");
//
//        config.setInstanceName("hazelcast-instance")
//                .addMapConfig(
//                        new MapConfig()
//                                .setName("configuration")
//                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
//                                .setEvictionPolicy(EvictionPolicy.LRU)
//                                .setTimeToLiveSeconds(-1));
//        return config;
//    }
//
////    @Bean
////    public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
////        return Hazelcast.newHazelcastInstance(hazelCastConfig);
////    }
//
//    @Bean
//    public Map<Long, Employee> accountMap(HazelcastInstance hazelcastInstance) {
//        return hazelcastInstance.getMap("my-map");
//    }
//
//    @Bean
//    public JetInstance jetInstance() {
//        return Jet.newJetInstance();
//    }
//}