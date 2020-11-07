alias dotfiles="/usr/bin/git --git-dir=$HOME/Manjaro-dotfiles --work-tree=$HOME"

# This is equivalent to entering the following function:
function dotfiles --wraps git --description 'alias dotfiles=/usr/bin/git --git-dir=$HOME/Manjaro-dotfiles --work-tree=$HOME'
	 /usr/bin/git --git-dir=$HOME/Manjaro-dotfiles/ --work-tree=$HOME $argv
end
