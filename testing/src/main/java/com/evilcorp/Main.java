package com.evilcorp;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.responses.GetResponse;

public class Main {
    public static void main(String[] args) throws ClientException, ApiException {
        System.out.println("Hello world!");
        var transportClient = HttpTransportClient.getInstance();
        var vkApi =new VkApiClient(transportClient);
        var actor = new UserActor(8001608, "3ebeabad8fbd76b9cc2596c7223e5d1f33b6ccc3077d3e3811a17149a8f4154e94b660a1fc007c359a157");
        var list = vkApi.groups().getMembers(actor).groupId("198188261").offset(100).execute().getItems();
        System.out.println("Id участников группы:");
        for (var st: list) {
            System.out.println(st);
        }
    }
}
