package sda.pizza;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PollyService {

    private final AmazonPollyClient polly;
    public PollyService(Region region) {
        polly = new AmazonPollyClient(new DefaultAWSCredentialsProviderChain(),
                new ClientConfiguration());
        polly.setRegion(region);
    }

    private Voice getVoiceByName(List<Voice> voices, String name) {
        for (Voice voice1 : voices) {
            if(voice1.getId().equals(name)){
                return voice1;
            }
        }
        return voices.get(0);
    }

    public void saveToFile(InputStream inputStream) throws IOException {

        String outputFile = "C:\\TMP\\pizza.mp3";
        Files.copy(inputStream, Paths.get(outputFile), StandardCopyOption.REPLACE_EXISTING);
    }

    public InputStream synthesize(String text, OutputFormat format, String person) throws IOException {
        DescribeVoicesRequest describeVoicesRequest = new DescribeVoicesRequest();
        DescribeVoicesResult describeVoicesResult = polly.describeVoices(describeVoicesRequest);
        List<Voice> voices = describeVoicesResult.getVoices();
        Voice voice = getVoiceByName(voices, person);

        SynthesizeSpeechRequest synthReq =
                new SynthesizeSpeechRequest().withText(text).withTextType(TextType.Ssml).withVoiceId(voice.getId())
                        .withOutputFormat(format);

        SynthesizeSpeechResult synthRes = polly.synthesizeSpeech(synthReq);

        return synthRes.getAudioStream();
    }
}


