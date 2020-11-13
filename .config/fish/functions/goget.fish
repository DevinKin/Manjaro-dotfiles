alias goget="GO111MODULE=on go get"

# This is equivalent to entering the following function:
function goget --wraps goget --description 'alias goget=GO111MODULE=on go get'
	GO111MODULE=on go get $argv
end
