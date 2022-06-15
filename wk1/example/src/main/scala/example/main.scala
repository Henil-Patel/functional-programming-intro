import  example.Lists.*;

@main def compute_sum() = {
    val l = List(4, -5, -6)
    val total = sum(l)
    println(total)
}

@main def compute_max() = {
    val l = List(-1, -1, -1)
    val max_val = max(l)
    println(max_val)
}
