/*
 * package com.example.oyoUser;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController
 * 
 * @RequestMapping("api/orders/") public class OrderController {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Autowired private RoomRepository roomRepository;
 * 
 * @PostMapping("/placebooking") public User placeOrder(@RequestBody
 * OrderRequest orderRequest) { User currentUser =
 * userRepository.saveAll(List.of(orderRequest.getUser())).get(0); return
 * currentUser; }
 * 
 * @GetMapping("/allbookings") public List<User> placeOrder() { return
 * userRepository.findAll(); }
 * 
 * 
 * }
 */