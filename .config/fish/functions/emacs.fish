alias emacs="emacs -Q"

# This is equivalent to entering the following function:
function emacs --wraps emacs --description 'alias emacs=emacs -Q'
    emacs -Q $argv
end