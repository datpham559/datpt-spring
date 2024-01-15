package rest.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rest.dto.ChatGPTResponse;
import rest.dto.ToolRequestDTO;
import rest.service.ToolAutomationService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ToolAutomationServiceImpl implements ToolAutomationService {
    @Override
    public void toolAutomationComment(ToolRequestDTO dto) {
        List<String> proxies = Arrays.asList(
                "proxy1_host:proxy1_port",
                "proxy2_host:proxy2_port"
        );
        try {
            testChat();
        }catch (Exception e){

        }

        System.setProperty("webdriver.chrome.driver", "D:\\chrome driver\\chromedriver-win64\\chromedriver.exe");
        getContentFromChatGPT("Trời nay đẹp quá");
        try {
            // Mỗi lần nhập nội dung bình luận, chọn ngẫu nhiên một proxy từ danh sách
            for (int i = 0; i < dto.getCountComment(); i++) { // Ví dụ: nhập 5 bình luận
                // Chọn ngẫu nhiên một proxy từ danh sách
                String randomProxy = getRandomProxy(proxies);

                // Tạo ChromeOptions để cấu hình proxy
                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--proxy-server=http://" + randomProxy);

                WebDriver driver = new ChromeDriver(chromeOptions);

                try {
                    login(driver);
                    Thread.sleep(2000);
                    driver.get(dto.getPath());
                    Thread.sleep(2000);
                    if (!Strings.isNullOrEmpty(dto.getContentElement())) {
                        WebElement contentElement = driver.findElement(By.id("[data-testid='tweetText']"));
                        Thread.sleep(2000);
                        String content = contentElement.getText();
                        Thread.sleep(2000);

                    }
                    if (!Strings.isNullOrEmpty(dto.getInputElementId())) {
                        WebElement commentInputByID = driver.findElement(By.id("inputText1"));
                        commentInputByID.sendKeys("Đây là bình luận tự động số " + i + 1);
                        driver.findElement(By.id("compareButton")).click();
                    }
                    if (!Strings.isNullOrEmpty(dto.getCssInputElement())) {
                        WebElement tweetInput = driver.findElement(By.cssSelector(dto.getCssInputElement()));
                        Thread.sleep(2000);
                        tweetInput.sendKeys("<3");
                        Thread.sleep(2000);
                        driver.findElement(By.cssSelector("[data-testid='tweetButtonInline']")).click();
                    }
                    if (!Strings.isNullOrEmpty(dto.getCssLikeElement())) {
                        WebElement tweetLike = driver.findElement(By.cssSelector(dto.getCssInputElement()));
                        tweetLike.click();
                    }

                } finally {
                    // Đóng trình duyệt sau mỗi lần nhập
                    driver.quit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getRandomProxy(List<String> proxies) {
        Random random = new Random();
        int index = random.nextInt(proxies.size());
        return proxies.get(index);
    }
    private void login (WebDriver driver){
        try {
            // Mở trang web Twitter
            driver.get("https://twitter.com/i/flow/login");
            Thread.sleep(2000);

            // Định vị trường nhập tên người dùng và nhập thông tin
            WebElement usernameInput = driver.findElement(By.name("text"));
            Thread.sleep(2000);
            usernameInput.sendKeys("datpham559");
            Thread.sleep(2000);
            usernameInput.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            // Định vị trường nhập mật khẩu và nhập thông tin
            WebElement passwordInput = driver.findElement(By.name("password"));
            Thread.sleep(2000);
            passwordInput.sendKeys("datpham553");
            Thread.sleep(2000);

            // Thực hiện đăng nhập bằng cách nhấn Enter
            passwordInput.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

            // (Optional) Chờ cho một số hoạt động tương tác khác sau khi đăng nhập
            // ...

            // In thông báo nếu đăng nhập thành công
            System.out.println("Đăng nhập thành công vào Twitter.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private String getContentFromChatGPT(String content){
        try {
//            URL url = new URL("https://api.openai.com/v1/engines/davinci-codex/completions");
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer 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");
            connection.setDoOutput(true);

//            String inputJson = "{\"prompt\": write somthing in content with length = 20 : " + content + "\"}";
            String inputJson = "{\n" +
                    "    \"model\": \"gpt-3.5-turbo\",\n" +
                    "    \"messages\": \n" +
                    "      {\n" +
                    "        \"role\": \"system\",\n" +
                    "        \"content\": \"You are a helpful assistant.\"\n" +
                    "      }\n" +
                    "  }";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = inputJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String testChat() throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();

        String url = "https://api.openai.com/v1/chat/completions";
        String json = mapper.writeValueAsString("{\n" +
                "    \"model\": \"gpt-3.5-turbo\",\n" +
                "    \"messages\": [\n" +
                "      {\n" +
                "        \"role\": \"system\",\n" +
                "        \"content\": \"You are a helpful assistant.\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"role\": \"user\",\n" +
                "        \"content\": \"Hello!\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("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");
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,requestEntity,String.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            ChatGPTResponse chatGptResponse = mapper.readValue(response.getBody(), ChatGPTResponse.class);
            String answer = chatGptResponse.getChoices()[chatGptResponse.getChoices().length-1].getText();
            if(!answer.isEmpty()) {
                System.out.println(answer.replace("\n","").trim());
            }
        } else {
            System.out.println("Error");
        }
        return null;
    }
}
