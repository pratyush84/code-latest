package interview;

import java.util.function.BiFunction;

public class Movie {
    enum Type{
        REGULAR(PriceService::computeChildrenPrice),
        NEW_RELEASE(PriceService::computeNewReleasePrice),
        CHILDREN(PriceService::computeChildrenPrice);

        public final BiFunction<PriceService,Integer,Integer> priceAlgo;

        Type(BiFunction<PriceService, Integer, Integer> priceAlgo) {
            this.priceAlgo = priceAlgo;
        }
    }

    private final Type type;
    public Movie(Type type) {
        this.type = type;
    }
}

interface NewReleasePriceRepo{
    double getFactor();
}

class PriceService{
    private final NewReleasePriceRepo repo;

    public int calc(int a, int b){
        return a+b;
    }


    public PriceService(NewReleasePriceRepo repo){
        this.repo = repo;
    }

    int computeNewReleasePrice(int days){
        return (int)(days * repo.getFactor());
    }

    int computeRegularPrice(int days){
        return days + 1;
    }

    int computeChildrenPrice(int days){
        return 5;
    }

    public int computePrice(Movie.Type type, int days){

        return type.priceAlgo.apply(this,days);
    }
}
