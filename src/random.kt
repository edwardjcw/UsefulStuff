package com.tomedev.useful

import org.apache.commons.lang3.RandomStringUtils

/**
 * This function ensures that the next randomized output is not the "except" input.
 */
fun randomAlphanumeric(count:Int, except:String, randomize : (Int)->String = randomAlphanumeric) : String
{
    return generateSequence { randomize(count) }.first { x: String -> x != except}
}

private val randomAlphanumeric : (Int) -> String = {x -> RandomStringUtils.randomAlphanumeric(x)}