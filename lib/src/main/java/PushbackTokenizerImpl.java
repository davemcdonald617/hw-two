import java.util.StringTokenizer;

public class PushbackTokenizerImpl implements PushbackTokenizer {

    // Class adaptor implementation with StringTokenizer as adaptee

    // Need link between underlying adaptee and this adapter.
    private StringTokenizer data;

    // To store nextToken
    private String storeData;

    //
    public PushbackTokenizerImpl(String text) {
        this.data = new StringTokenizer(text);
    }

    @Override
    public String nextToken() {
        //store information before nextToken()
        storeData = data.nextToken();
        return storeData;
    }

    @Override
    public boolean hasMoreTokens() {
        return data.hasMoreTokens();
    }

    // the token read is pushed back, so it can be read again using nextToken.
    @Override
    public void pushback() {
        // If nextToken hasn't been called yet.
        if(storeData != null) {
            String tempStr = storeData;
            while (data.hasMoreTokens()) {
                tempStr = tempStr.concat(" ").concat(data.nextToken());
            }
            data = new StringTokenizer(tempStr);
        }
    }
}
