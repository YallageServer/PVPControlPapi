package qanyiovo.pvpcontrol.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class pvpcp implements CommandExecutor {
    private final JavaPlugin plugin;

    public pvpcp(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // 判断子指令是否是"reload"
        if (args[0].equalsIgnoreCase("reload")) {
            // 判断是否有权限
            if (sender.hasPermission("pvpcp.admin")) {
                // 重载配置文件
                this.plugin.reloadConfig();
                sender.sendMessage("重载成功");
            } else {
                sender.sendMessage("你没有权限");
            }
        } else if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage("------PVPControlPapi------\n/pvpcp reload - 重载配置");
        }
        else {
            sender.sendMessage("未知的子指令，输入/pvpcp help查看帮助。");
        }

        return true;
    }
}
