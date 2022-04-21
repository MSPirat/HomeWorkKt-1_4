import org.junit.Test

import org.junit.Assert.*
import ru.netology.transferFeeMastercardMaestro
import ru.netology.transferFeeVisaMir

class DifferentComissionKtTest {

	@Test
	fun transferFeeMastercardMaestro_withoutComission() {
		//arrange
		val enterTransaction = 10_000_00
		//act
		val result = transferFeeMastercardMaestro(
			enterSumTransactionTemporaryMastercardMaestro = enterTransaction
		)
		//assert
		assertEquals(1, result)
	}

	@Test
	fun transferFeeMastercardMaestro_withComission() {
		val enterTransaction = 100_000_00
		val result = transferFeeMastercardMaestro(
			enterSumTransactionTemporaryMastercardMaestro = enterTransaction
		)
		assertEquals(620, result)
	}

	@Test
	fun transferFeeVisaMir_fixComission() {
		val enterTransaction = 2500_00
		val result = transferFeeVisaMir(
			enterSumTransactionTemporaryVisaMir = enterTransaction
		)
		assertEquals(3500, result)
	}

	@Test
	fun transferFeeVisaMir_percentComission() {
		val enterTransaction = 750_000_00
		val result = transferFeeVisaMir(
			enterSumTransactionTemporaryVisaMir = enterTransaction
		)
		assertEquals(5625, result)
	}
}