-- wrk -c 500 -t 10 -d 30s -s ./wrk-test.lua --latency http://localhost:8080/payments

-- init random
setup = function(thread)
   math.randomseed(os.time())
end

request = function()
   local path = "/payments"
   local body = "{\"userId\":" .. math.random(0, 1000) .. "}"

   wrk.method = "POST"
   wrk.headers["Content-Type"] = "application/json"

   return wrk.format("POST", path, wrk.headers, body)
end

done = function(summary, latency, requests)
   io.write("------------------------------\n")
   for _, p in pairs({ 50, 90, 99, 99.999 }) do
      n = latency:percentile(p)
      io.write(string.format("%g%%,%d\n", p, n))
   end
end
