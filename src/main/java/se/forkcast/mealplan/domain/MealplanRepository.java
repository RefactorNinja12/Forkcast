package se.forkcast.mealplan.domain;

import java.util.List;
import java.util.Optional;


public interface MealplanRepository {

    Mealplan save(Mealplan mealplan);

    Optional<Mealplan> findById(Long id);

    List<Mealplan> findByWeekNumber(int weekNumber);
    List<Mealplan> findAll(); 
    void remove(Mealplan mealplan);
}
