package com.sksamuel.avro4k.streams

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec
import kotlinx.serialization.Serializable

class BasicStreamTest : FunSpec() {
   init {

      @Serializable
      data class BooleanTest(val z: Boolean)

      @Serializable
      data class StringTest(val z: String)

      @Serializable
      data class FloatTest(val z: Float)

      @Serializable
      data class DoubleTest(val z: Double)

      @Serializable
      data class IntTest(val z: Int)

      @Serializable
      data class LongTest(val z: Long)

      test("read write out booleans") {
         writeRead(BooleanTest(true), BooleanTest.serializer())
         writeRead(BooleanTest(false), BooleanTest.serializer()) {
            it["z"] shouldBe false
         }
         writeRead(BooleanTest(true), BooleanTest.serializer()) {
            it["z"] shouldBe true
         }
      }

      test("read write out strings") {
         writeRead(StringTest("Hello world"), StringTest.serializer())
      }

      test("read write out longs") {
         writeRead(LongTest(65653L), LongTest.serializer())
      }

      test("read write out ints") {
         writeRead(IntTest(44), IntTest.serializer())
      }

      test("read write out doubles") {
         writeRead(DoubleTest(3.235), DoubleTest.serializer())
      }

      test("read write out floats") {
         writeRead(FloatTest(3.4F), FloatTest.serializer())
      }
   }
}