package org.example.variables

fun main () {
    //Por padrão, você deve se esforçar para declarar todas as variáveis em Kotlin com a val palavra-chave;
    // altere para var se necessário. Usar referências somente leitura, objetos imutáveis e funções sem
    // efeitos colaterais permite que você aproveite os benefícios oferecidos pelo estilo de programação funcional

    //val(value) = Somente leitura, só pode ser atribuida 1x
    //var(variable) = referência reatribuível
    val question: String = "A questão fundamental da vida, do universo e tudo mais"
    val answer: Int = 42

    //Também é possível omitir o tipo devido a inferência de tipo do próprio Kotlin
    //val question = "A questão fundamental da vida, do universo e tudo mais"
    //val answer  = 42

    //7,5 * 10ˆ6 = 7.500.000,00 -> Tipo Double
    val yearsToCompute = 7.5e6

    //Pode iniciar val com valores diferentes desde que o compilador possa garantir que apenas uma das intruções
    //de inicialização será executada
    fun canPerformOperation(): Boolean{
        return true
    }

    //Não inicializada, apenas declaração de tipo
    val result: String

    if (canPerformOperation()){
        result = "Sucesso"
    } else {
        result = "Não é possível executar a operação"
    }
    //Por mais que funcione você não pode alterar o tipo já declarado


}