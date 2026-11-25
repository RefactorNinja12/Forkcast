package se.forkcast.mealplan.infrastructure;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import se.forkcast.mealplan.domain.Mealplan;
import se.forkcast.mealplan.domain.MealplanRepository;


@Repository
public class JpaMealplanRepository implements MealplanRepository {

    private final SpringDataMealplanRepository jpa;

    JpaMealplanRepository(SpringDataMealplanRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Mealplan save(Mealplan mealplan) {
        return jpa.save(mealplan);
    }

    @Override
    public Optional<Mealplan> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public List<Mealplan> findByWeekNumber(int weekNumber) {
        return jpa.findByWeekNumber(weekNumber);
    }

    @Override
    public List<Mealplan> findAll() {
       return jpa.findAll();    
    }

    @Override
    public void remove(Mealplan mealplan) {
        jpa.delete(mealplan);
    }
}
