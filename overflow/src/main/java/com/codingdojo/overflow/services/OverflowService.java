package com.codingdojo.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.NewQuestion;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.repositories.AnswerRepository;
import com.codingdojo.overflow.repositories.QuestionRepository;
import com.codingdojo.overflow.repositories.TagRepository;

@Service
public class OverflowService {
private final QuestionRepository qRepo;
private final AnswerRepository aRepo;
private final TagRepository tRepo;

public OverflowService(QuestionRepository repo1,AnswerRepository repo2, TagRepository repo3) {
	this.qRepo=repo1;
	this.aRepo=repo2;
	this.tRepo=repo3;
}

public  List<Question> getAllQuestions(){
	return qRepo.findAll();
}

public  List<Answer> getAllAnswers(){
	return aRepo.findAll();
}

public  List<Tag> getAllTags(){
	return tRepo.findAll();
}

public void addQuestion(Question question) {
	qRepo.save(question);
	
}

public void addAnswer(Answer answer) {
	aRepo.save(answer);
}

public void addTag(Tag tag) {
	tRepo.save(tag);
}

public Question findQuestion(Long id) {
	return qRepo.findById(id).orElse(null);
}

public void createQuestion(NewQuestion question) {
	// TODO: make a real question here
	List<Tag> questionsTags = new ArrayList<Tag>();
	for(String subject: question.splitTags()) {
		Tag tag = this.tRepo.findBySubject(subject).orElse(null);
		if(tag == null) {
			tag = new Tag(subject);
			this.tRepo.save(tag);
		}
		if(!questionsTags.contains(tag))
			questionsTags.add(tag);
	}
	Question newQuestion = new Question(question.getQuestion(), questionsTags);
	this.qRepo.save(newQuestion);
}


}
