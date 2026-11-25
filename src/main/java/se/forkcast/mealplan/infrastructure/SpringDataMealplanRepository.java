package se.forkcast.mealplan.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se.forkcast.mealplan.domain.Mealplan;

interface SpringDataMealplanRepository extends JpaRepository<Mealplan, Long> {

   
    List<Mealplan> findByWeekNumber(int weekNumber);
}
