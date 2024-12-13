import java.util.List;
import java.util.Map;

public record ConversionApi(String result, String base_code, String target_code,
                            float conversion_rate, float conversion_result , int year,
                            int month, int day, Map<String, Float>conversion_rates,
                            Map<String, String> target_data, List<List<String>> supported_codes) {
}