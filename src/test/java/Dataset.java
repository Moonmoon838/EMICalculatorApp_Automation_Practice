import org.testng.annotations.DataProvider;

public class Dataset {

    @DataProvider(name = "data-provider")
    public Object[][] setData(){
        return new Object[][]{
                {50000, 10, 2, 2, 2307.25, 5373.91, 1000, 55373.91},
                {100000, 10, 3, 2.5, 3226.72, 16161.87, 2500, 116161.87},
                {200000, 8, 3, 2.5, 6267.27, 25621.83, 5000, 225621.83},
        };
    }


    @DataProvider(name = "data-provider1")
    public Object[][] setData1(){
        return new Object[][]{
                {50000, 10, 2, 2},
                {100000, 10, 3, 2.5},
                {200000, 8, 3, 2.5},
        };
    }
}
