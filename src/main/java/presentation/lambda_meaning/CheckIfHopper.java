package presentation.lambda_meaning;

/**
 * Created by Serhii K. on 10/20/2015.
 */
public class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animal a) {
        return a.canHop();
    }
}
