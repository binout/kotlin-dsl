mkdir -p output

echo "Generate slides"
docker run --rm -v $(pwd):/slides amouat/decktape deck https://binout.github.io/kotlin-dsl/index.html  /slides/output/bdxio-kotlin-dsl.pdf
