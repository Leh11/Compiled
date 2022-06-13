

function stringMatching(text::String, query::String)
    M = length(query)
    N = length(text)

    indexQ::Int = 0
    indexT::Int = 0

    for indexT in range(1, N - M)
        for indexQ in range(1, M)
            if query[indexQ] != text[(indexQ + indexT) - 1]
                break
            end
            println(query[indexQ])
        end
        if indexQ == M
            print("Existe")
            return indexT
        end
    end
    return length(text)
end

dataOf = readline()
query = readline()

println(stringMatching(dataOf, query))