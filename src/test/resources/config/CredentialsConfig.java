@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    String login();
    String password();
}