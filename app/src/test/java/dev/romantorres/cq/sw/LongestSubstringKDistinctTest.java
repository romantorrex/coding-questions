package dev.romantorres.cq.sw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringKDistinctTest {

    @Test
    public void findLongestLength() {
        assertThat(LongestSubstringKDistinct.findLongestLength("araaci", 2)).isEqualTo(4);
        assertThat(LongestSubstringKDistinct.findLongestLength("araaci", 1)).isEqualTo(2);
        assertThat(LongestSubstringKDistinct.findLongestLength("cbbebi", 3)).isEqualTo(5);
        assertThat(LongestSubstringKDistinct.findLongestLength("cbbebi", 10)).isEqualTo(6);
    }
}