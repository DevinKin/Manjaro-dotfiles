alias pq="proxychains -q"

# This is equivalent to entering the following function:
function pq --wraps proxychains --description 'alias pq=proxychains -q'
	proxychains -q $argv
end
