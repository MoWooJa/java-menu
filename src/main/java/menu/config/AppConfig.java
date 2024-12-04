package menu.config;

public class AppConfig {

    public OncallController oncallController() {
        return new OncallController(inputView(), outputView(), domainService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private DomainService domainService() {
        return new DomainService(domainFactory());
    }

    private DomainFactory domainFactory() {
        return new DomainFactory();
    }

}
