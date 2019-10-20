import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RandomKtTest {

    private fun pretendRandom(randomSequence: List<String>): (Int) -> String {
        val iterator = randomSequence.iterator()

        return { _: Int -> iterator.next() }
    }

    @Test
    fun randomAlphanumeric() {
        val size = 10
        val randomSequence = generateSequence { RandomStringUtils.randomAlphanumeric(size) }
        val randoms = randomSequence.take(2).toList()
        val currentRandom = randoms[0]
        val nextRandom = randoms[1]

        val randomAlphanumeric = com.tomedev.useful.randomAlphanumeric(size, currentRandom, pretendRandom(randoms))
        assert(randomAlphanumeric == nextRandom)
    }
}