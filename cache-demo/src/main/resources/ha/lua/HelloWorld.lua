local a = {}
a["key"] = "value"
local key = 10
a[key] = "22"
a[key] = a[key] + 11
for k, v in pairs(a) do
    print(k .. " : " .. v)
end