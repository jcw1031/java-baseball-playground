package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String actual = value.substring(1, value.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("charAt()을 사용할 때 문자의 길이를 벗어나면 예외가 발생한다.")
    @Test
    void charAt() {
        String value = "abc";
        assertThatThrownBy(() -> value.charAt(value.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
