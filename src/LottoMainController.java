import service.LottoService;

public class LottoMainController {
    public static void main(String[] args) {
        LottoService service = new LottoService();
        service.lottoStart();
    }
}
