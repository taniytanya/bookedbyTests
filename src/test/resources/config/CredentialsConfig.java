@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    String token();
    String chat();
}