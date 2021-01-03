package edu.lodz.pl.biu.backend.security.controllers;

import edu.lodz.pl.biu.backend.Question;
import edu.lodz.pl.biu.backend.repository.QuestionRepository;
import edu.lodz.pl.biu.backend.repository.UserRepository;
import edu.lodz.pl.biu.backend.security.User;
import edu.lodz.pl.biu.backend.security.payload.request.QuestionRequest;
import edu.lodz.pl.biu.backend.security.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class QuestionController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("question-form")
    public ResponseEntity<?> processQuestionForm(@Valid @RequestBody QuestionRequest questionRequest) {
        User sendingUser = userRepository.findByUsername(questionRequest.getUsername()).get();
        Question question = new Question(questionRequest.getTopic(), questionRequest.getText(), sendingUser);
        questionRepository.save(question);
        return ResponseEntity.ok(new MessageResponse("Question saved successfully!"));
    }

}
