package ua.site.javabook.util;

import org.springframework.lang.Nullable;
import ua.site.javabook.model.EntityBook;
import ru.javawebinar.topjava.to.MealTo;
import ua.site.javabook.to.BookTo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MealsUtil {
    public static final int DEFAULT_COST_NORM = 100;

    private MealsUtil() {
    }

    public static List<EntityBook> getTos(Collection<EntityBook> eb, int costNorm) {
        return getFiltered(eb, costNorm, meal -> true);
    }

    public static List<BookTo> getFilteredTos(Collection<Meal> meals, int caloriesPerDay, @Nullable LocalTime startTime, @Nullable LocalTime endTime) {
        return getFiltered(meals, caloriesPerDay, meal -> Util.isBetweenInclusive(meal.getTime(), startTime, endTime));
    }

    private static List<BookTo> getFiltered(Collection<EntityBook> eb, int cost, Predicate<EntityBook> filter) {

        return meals.stream()
                .filter(filter)
                .map(meal -> createTo(meal, caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    public static MealTo createTo(Meal meal, boolean excess) {
        return new MealTo(meal.getId(), meal.getDateTime(), meal.getDescription(), meal.getCalories(), excess);
    }
}