package ru.netology

const val MASTERCARD = "MasterCard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "МИР"
const val VKPAY = "VKPay"

//val enterSumTransaction = 50_000_00

fun choicePaymentSystem(): String {
	print(
		"Введите номер для выбора платёжной системы: \n" +
				"1. MasterCard \n" +
				"2. Maestro \n" +
				"3. Visa \n" +
				"4. Мир \n" +
				"5. VKPay \n"
	)
	val choice = when (readln().toInt()) {
		1 -> MASTERCARD
		2 -> MAESTRO
		3 -> VISA
		4 -> MIR
		else -> VKPAY
	}
	return choice
}

fun transferFeeMastercardMaestro(enterSumTransactionTemporaryMastercardMaestro: Int): Int {
	return if (enterSumTransactionTemporaryMastercardMaestro < 75_000_00) 0
	else (((enterSumTransactionTemporaryMastercardMaestro * 0.006) + 20_00) / 100).toInt()
}

fun transferFeeVisaMir(enterSumTransactionTemporaryVisaMir: Int): Int {
	return if ((enterSumTransactionTemporaryVisaMir * 0.0075).toInt() < 35_00) 35_00
	else ((enterSumTransactionTemporaryVisaMir * 0.0075) / 100).toInt()
}

fun moneyTransferFee(): Int {
	val amountKop = when (choicePaymentSystem()) {
		MASTERCARD -> transferFeeMastercardMaestro(10_000_00)
		MAESTRO -> transferFeeMastercardMaestro(100_000_00)
		VISA -> transferFeeVisaMir(2500_00)
		MIR -> transferFeeVisaMir(750_000_00)
		else -> 0
	}
	return amountKop
}

fun main() {
	println("Комиссия за перевод ${moneyTransferFee()} коп.")
}