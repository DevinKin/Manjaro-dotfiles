    set -Ux GTK_IM_MODULE fcitx
    set -Ux QT_IM_MODULE fcitx
    set -Ux XMODIFIERS "@im fcitx"

    set -Ux GO111MODULE auto

    set -Ux GOPROXY https://goproxy.cn
    set -Ux GOROOT /usr/lib/go
    set -Ux GOPATH $HOME/go 
    set PATH $PATH:$GOROOT/bin:$GOPATH/bin

    # 设置 http 代理
    set -Ux HTTP_PROXY http://127.0.0.1:8889
    set -Ux HTTPS_PROXY http://127.0.0.1:8889

    # 或, 设置 socket 代理(clash)
    # set -Ux HTTP_PROXY socks5://127.0.0.1:1089
    # set -Ux HTTPS_PROXY socks5://127.0.0.1:1089


    # npm without sudo https://docs.npmjs.com/resolving-eacces-permissions-errors-when-installing-packages-globally
    set -Ux USER_NPM_GLOBAL $HOME/.npm-global
    set PATH $PATH:$USER_NPM_GLOBAL/bin