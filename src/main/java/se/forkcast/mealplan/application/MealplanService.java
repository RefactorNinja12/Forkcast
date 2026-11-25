package se.forkcast.mealplan.application;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import se.forkcast.mealplan.domain.Mealplan;
import se.forkcast.mealplan.domain.MealplanRepository;


@Service 
public class MealplanService {
    private final MealplanRepository repo;

    public MealplanService(MealplanRepository repo) {
        this.repo = repo; 
    }

    public Mealplan addMealplane(String description, int weekNumber){
        Mealplan mealplan = new Mealplan(weekNumber, description);
        return repo.save(mealplan);
    }
    public Mealplan findById(Long id){
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Mealplan " + id + "Not found")); 
    }
    public List<Mealplan> findAll(){
        return repo.findAll();
    }
    @Transactional 
    public void UpdateMealplan(Long id, String description, int weekNumber){
        Mealplan meal = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Mealplan " + id + "Not found")); 
        meal.setDescription(description);
        meal.setWeekNumber(weekNumber);
    }
    public void remove(Long id){
        Mealplan meal = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Mealplan " + id + "Not found"));
        repo.remove(meal);
    }
    public List<Mealplan> findByWeekNumber(int weekNumber){
        return repo.findByWeekNumber(weekNumber);
    }
}
