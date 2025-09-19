export const API = import.meta.env.VITE_API_URL ?? "";
export function buildUrl(path: string) {
    return API ? `${API}${path}` : path;
}
