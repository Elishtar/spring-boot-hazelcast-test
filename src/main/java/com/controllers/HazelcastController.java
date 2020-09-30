//package com.controllers;
//
//import com.Employee;
//import com.Sex;
//import com.hazelcast.core.*;
//import com.hazelcast.jet.IListJet;
//import com.hazelcast.jet.IMapJet;
//import com.hazelcast.jet.JetInstance;
//import com.hazelcast.jet.pipeline.Pipeline;
//import com.hazelcast.jet.pipeline.Sinks;
//import com.hazelcast.jet.pipeline.Sources;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//import static com.hazelcast.jet.Traversers.traverseArray;
//import static com.hazelcast.jet.aggregate.AggregateOperations.counting;
//import static com.hazelcast.jet.function.Functions.wholeItem;
//
//@RestController
//@RequestMapping("/hazelcast")
//public class HazelcastController {
//
//    private final Logger logger = LoggerFactory.getLogger(HazelcastController.class);
////    @Autowired
////    private HazelcastInstance hazelcastInstance;
//    @Autowired
//    private JetInstance jetInstance;
//    @Autowired
//    private Map<Long, Employee> accountMap;
//
////    @Autowired
////    HazelcastController(HazelcastInstance hazelcastInstance) {
////        this.hazelcastInstance = hazelcastInstance;
////    }
//
////    @PostMapping(value = "/write-data")
////    public String writeDataToHazelcast(@RequestParam String key, @RequestParam String value) {
////        final LifecycleService lifecycleService = hazelcastInstance.getLifecycleService();
////        lifecycleService.addLifecycleListener(event -> {
////            if(event.getState().equals(LifecycleEvent.LifecycleState.SHUTTING_DOWN)) {
////                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
////                System.out.println("shutting down");
////                try {
////                    TimeUnit.SECONDS.sleep(3);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
////            }
////        });
////        IdGenerator idGenerator = hazelcastInstance.getIdGenerator("generator");
////        final long id = idGenerator.newId();
////        Sex sex = Sex.MAIL;
////        if (id%2 == 0) sex = Sex.FMAIL;
////        accountMap.put(id, new Employee(id, "name", 2, sex, Arrays.asList(new Employee(id+1, "folk", 1, sex, Collections.emptyList()))));
////        return "Data is stored.";
////    }
////
////    @GetMapping(value = "/read-data")
////    public Employee readDataFromHazelcast(@RequestParam String key) {
////        return accountMap.get(key);
////    }
////
////    @GetMapping(value = "/read-all-data")
////    public Map<Long, Employee> readAllDataFromHazelcast() {
////        return hazelcastInstance.getMap("my-map");
////    }
//
//    @GetMapping(value = "/pipeline")
//    public String pipeline() {
//        List<String> sentences = new ArrayList<>();
//        sentences.add("The first second was alright, but the second second was tough.");
//        final String second = "second";
//
//        long count = 0;
//        final IListJet<Object> list = jetInstance.getList("list");
//
//        list.addAll(sentences);
//        final Pipeline pipeline = createPipeline();
//        jetInstance.newJob(pipeline).join();
//
//        final IMapJet<Object, Object> map = jetInstance.getMap("map");
//
//        return map.get(second).toString();
//    }
//
//    private Pipeline createPipeline() {
//        Pipeline p = Pipeline.create();
//        p.drawFrom(Sources.<String>list("list"))
//                .flatMap(
//                        word -> traverseArray(word.toLowerCase().split("\\W+")))
//                .filter(word -> !word.isEmpty())
//                .groupingKey(wholeItem())
//                .aggregate(counting())
//                .drainTo(Sinks.map("map"));
//        return p;
//
//    }
//}
