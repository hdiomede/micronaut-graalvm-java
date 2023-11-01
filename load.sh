perf stat ls &
export PERF_ID=$!
while [ "$(curl -s -o /dev/null -L -w ''${http_code}'' http://localhost:8080/hello)" != 200]
    do sleep 0.001;
done

hey -n 100 http://localhost:8080/hello
export MY_PID="$(pgrep -P $PERF_ID)"
kill $MY_PID
