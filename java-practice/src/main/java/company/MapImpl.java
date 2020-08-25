package company;

import static org.mockito.Mockito.*;

public class MapImpl {
    public static void main(String[] args) {
        NewReleasePriceRepo repo = mock(NewReleasePriceRepo.class);
        when(repo.getFactor()).thenReturn(2d);
        new PriceService(repo).computePrice(Movie.Type.CHILDREN,2);
    }
}
